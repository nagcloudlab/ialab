import Foo from "./Foo";
import Bar from "./Bar";
import Button from "./Button";

function App() {
  return (
    <div className="">
      <Foo />
      <Bar />
      <Button href="http://www.react.js.org">
        React
      </Button>
      <Button p={true} href="http://www.react.js.org">
        React
      </Button>
    </div>
  );
}

export default App;
