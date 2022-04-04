import axios from "axios";
import { ChangeEvent, FunctionComponent, useEffect, useState } from "react";
import Employee from "../model/employee";

interface EmpUpdateProps {
  modifyEmpid: number;
  completed:(message:string)=>void;
  cancel:()=>void
}

const EmpUpdate: FunctionComponent<EmpUpdateProps> = (
  props: EmpUpdateProps
) => {
  const [emp, setEmp] = useState<Employee>({
    empid: 0,
    name: "",
    salary: 0,
    dob: new Date(),
  });
  const [message, setMessage] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    let url = `http://localhost:8080/employees/${props.modifyEmpid}`;
    axios.get(url).then(
      (response) => {
        setEmp(response.data);
        setLoading(false);
      },
      (error) => {
        setMessage(error.response.data.message);
      }
    );
  }, []);

  let handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    let name = e.target.name;
    let value = e.target.value;
    switch(name){
        case 'name': emp[name]=value; break;
        case 'salary': emp[name]=parseFloat(value); break;
        case 'dob': emp[name] = new Date(value);
    }
  };

  let saveData=()=>{
      axios.put("http://localhost:8080/employees",emp)
      .then(
          (response)=>{ props.completed(response.data.message)},
          (error)=>{ props.completed(error.response.data.message) }
      )
  }

  if (loading) {
    return <h4>loading .....</h4>;
  }

  return (
    <div>
      <h3>Modify Employee</h3>
      <div className="form-group">
        Employee Id:
        <input
          type="number"
          className="form-control"
          name="empid"
          defaultValue={emp.empid}
          readOnly
        />
      </div>
      <div className="form-group">
        Name:
        <input
          className="form-control"
          name="name"
          defaultValue={emp.name}
          onChange={handleChange}
        />
      </div>
      <div className="form-group">
        Salary:
        <input
          type="number"
          className="form-control"
          name="salary"
          defaultValue={emp.salary}
          onChange={handleChange}
        />
      </div>
      <div className="form-group">
        Date of Birth:
        <input
          type="date"
          className="form-control"
          name="dob"
          defaultValue={emp.dob.toLocaleString()}
          onChange={handleChange}
        />
      </div>
      <div>
        <button className="btn btn-success" onClick={saveData} >Save</button>
        <button className="btn btn-danger" onClick={ props.cancel}>Cancel</button>
      </div>
    </div>
  );
};

export default EmpUpdate;
