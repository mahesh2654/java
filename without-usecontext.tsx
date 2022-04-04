import {FunctionComponent, useState}  from 'react';

type UserProps={
    user:string;
}
export default function CompWithoutContext() {
  const [user, setUser] = useState("Rajul Jacob");

  return (
    <>
      <h1>{`Hello ${user}!`}</h1>
      <Component2 user={user} />
    </>
  );
}

const Component2: FunctionComponent<UserProps> = (props:UserProps) => {

    return (
        <>
        <h1>Component 2</h1>
        <Component3 user={props.user} />
      </>
        
         );
}

const Component3: FunctionComponent<UserProps> = (props:UserProps) => {
  return (
    <>
      <h1>Component 3</h1>
      <Component4 user={props.user} />
    </>
  );
}

const Component4: FunctionComponent<UserProps> = (props:UserProps) => {
  return (
    <>
      <h1>Component 4</h1>
      <Component5 user={props.user} />
    </>
  );
}

const Component5: FunctionComponent<UserProps> = (props:UserProps) => {
  return (
    <>
      <h1>Component 5</h1>
      <h2>{`Hello ${props.user} again!`}</h2>
    </>
  );
}
