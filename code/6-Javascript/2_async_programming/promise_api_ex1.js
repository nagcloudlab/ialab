
//------------------------------------------------------
// Trainer ( dependency / producer / publisher)
//------------------------------------------------------

const trainer = {
    getSubject(sub) {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve(1);
                // reject("oops")
            }, 3000);
        });
        return promise;
    }
}


//------------------------------------------------------
// Manager ( dependency / producer / publisher)
//------------------------------------------------------


const manager = {
    getWork(sub) {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve(sub * sub);
            }, 5000);
        });
        return promise;
    }
}
//------------------------------------------------------
// Employee ( dependent / consumer / subscriber)
//------------------------------------------------------
// callback
const employee = {
    doLearnAndWorkV1() {
        // ES6
        const promise = trainer.getSubject("sub");
        promise.then(
            sub => {
                console.log("employee learning " + sub)
                let promise = manager.getWork(sub)
                promise.then(
                    work => {
                        console.log("emloyee working on " + work)
                    }),
                    err => {
                        console.log("employee handling error " + err);
                    }
            },
            err => {
                console.log("employee handling error " + err);
            })
        console.log("employee on email work");
    },
    // ES7, to avoid callback hell 
    async asyncLearnAndWork() {
        try {
            let sub = await trainer.getSubject('sub')
            console.log("employee learning " + sub);
            let work = await manager.getWork(sub)
            console.log("employee working " + work);
        } catch (err) {
            console.log("employee handling error " + err);
        }
    },
    doLearnAndWorkV2() {
        this.asyncLearnAndWork()
        console.log("employee on email work");
    }
}

employee.doLearnAndWorkV2()