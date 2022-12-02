
const Rx = require('rxjs')
const { filter, map, bufferCount, debounceTime } = require('rxjs/operators')

//--------------------------------------------------------------------
// Trainer
//--------------------------------------------------------------------

const stream = new Rx.Subject() // Observable stream
const trainer = {
    getFullStackTopics() {
        let i = 0;
        let interval = setInterval(() => {
            i++;
            if (i == 5000) {
                console.log("trainer propagating error into stream");
                stream.error(new Error("oops"));
                clearInterval(interval);
            } else {
                console.log("trainer propagating change/data/event into stream");
                stream.next(i)
            }

            if (i == 11) {
                console.log("trainer closing stream");
                stream.complete()
                clearInterval(interval);
            }

        }, 5000)
        return stream;
    }
}



//--------------------------------------------------------------------
// Employee1
//--------------------------------------------------------------------

const employee1 = {
    doLearnAndWork() {
        console.log("employee1 requesting fullstack topics on trainer");
        const stream = trainer.getFullStackTopics()
        stream
            .pipe(filter(topic => topic % 2 === 0))
            .pipe(map(eventTopic => eventTopic * 10))
            .pipe(Rx.bufferCount(2))
            .pipe(debounceTime(3000))
            .subscribe({
                next: topic => console.log("employee1 reacting/learning change/data/event i.e topic - " + topic),
                error: (err) => console.log("employee1 handling error - " + err),
                complete: () => console.log("employee1 - Thanks for all the topics")
            })
        console.log("employee with other work..if exist");
    }
}


employee1.doLearnAndWork()



//--------------------------------------------------------------------
// Employee2
//--------------------------------------------------------------------

// const employee2 = {
//     doLearnAndWork() {
//         console.log("employee2 requesting fullstack topics on trainer");
//         const stream = trainer.getFullStackTopics()
//         stream.subscribe({
//             next: topic => console.log("employee2 reacting/learning change/data/event i.e topic - " + topic),
//             error: (err) => console.log("employee2 handling error - " + err),
//             complete: () => console.log("employee2 - Thanks for all the topics")
//         })
//         console.log("employee with other work..if exist");
//     }
// }


// employee2.doLearnAndWork()