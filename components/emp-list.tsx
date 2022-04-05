import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Employee from "../model/employee";


const EmpList = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [message, setMessage] = useState<string>("");
  const [empid, setEmpid] = useState<number>(0);

  useEffect(() => {
    getDateFromServer();
  }, []);

  let getDateFromServer = () => {
    setEmployees([]);
    axios.get("http://localhost:8080/employees").then(
      (response) => {
        setEmployees(response.data);
      },
      (error) => {
        setMessage(
          `${error.response.data.code}: ${error.response.data.message}`
        );
      }
    );
  };

  let deleteData = (eid: number) => {
    axios.delete(`http://localhost:8080/employees/${eid}`).then(
      (response) => {
        setMessage(response.data.message);
        getDateFromServer();
        setTimeout(() => {
          setMessage("");
        }, 4000);
      },
      (error) => {
        setMessage(error.response.data.message);
        getDateFromServer();
        setTimeout(() => {
          setMessage("");
        }, 4000);
      }
    );
  };


  return (
    <div className="container mt-5">
    
          <h3 style={{ textAlign: "center", color: "blue" }}>Employee List</h3>

          <table className="table table-striped table-hover">
            <thead>
              <tr>
                <th>EMP ID</th>
                <th>NAME</th>
                <th>SALARY</th>
                <th>D O B</th>
                <th>ACTION</th>
              </tr>
            </thead>
            <tbody>
              {employees.map((e) => {
                return (
                  <tr key={e.empid}>
                    <td>{e.empid}</td>
                    <td>{e.name}</td>
                    <td>{e.salary}</td>
                    <td>{e.dob.toLocaleString("en-GB")}</td>
                    <td>
                      <button
                        className="btn btn-danger"
                        onClick={() => deleteData(e.empid)}
                      >
                        Delete
                      </button>
                      <Link className="btn btn-primary" to={`/updateemp/${e.empid}`} >
                        Modify
                      </Link>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
         
          {message != "" ? (
            <p className="alert alert-success">{message}</p>
          ) : null}
        </div>
  );
};

export default EmpList;