import {createContext, FunctionComponent, useContext, useState}  from 'react';

const UserContext =createContext<string>('')  // empty string default value

export default function CompWithContext() {
  const [user, setUser] = useState("Rajul Jacob");

  return (
    <UserContext.Provider value={user}>
    <h1>{`Hello ${user}!`}</h1>
    <Component2  />
  </UserContext.Provider>
  );
}

const Component2: FunctionComponent = () => {

    return (
        <>
        <h1>Component 2</h1>
        <Component3  />
      </>
        
         );
}



const Component3: FunctionComponent = () => {
  return (
    <>
      <h1>Component 3</h1>
      <Component4  />
    </>
  );
}

const Component4: FunctionComponent = () => {
  return (
    <>
      <h1>Component 4</h1>
      <Component5  />
    </>
  );
}

const Component5: FunctionComponent = () => {
    const user=useContext(UserContext)
  return (
    <>
      <h1>Component 5</h1>
      <h2>{`Hello ${user} again!`}</h2>
    </>
  );
}
