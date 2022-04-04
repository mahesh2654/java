import axios from "axios";
import { useEffect, useState } from "react";
import Employee from "../model/employee";
import EmpCreate from "./emp-create";
import EmpUpdate from "./emp-update";

const EmpList = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [message, setMessage] = useState<string>("");
  const [empid, setEmpid] = useState<number>(0);
  const [addNew, setAddNew] = useState<boolean>(false);

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

  let modifyEmployee = (eid: number) => {
    setEmpid(eid);
  };

  let updateCanceled = () => {
    setMessage("Modify cancelled");
    setEmpid(0);
    setTimeout(() => {
      setMessage("");
    }, 4000);
  };
  let closeUpdate = (message: string) => {
    getDateFromServer();
    setMessage(message);
    setEmpid(0);
    setTimeout(() => {
      setMessage("");
    }, 4000);
  };

  let createEmployee = () => {
    setAddNew(true);
  };
  let createCompleted = () => {
    setAddNew(false);
    getDateFromServer();
  };
  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-6">
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
                      <button
                        className="btn btn-primary"
                        onClick={() => modifyEmployee(e.empid)}
                      >
                        Modify
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
          <button onClick={createEmployee} className="btn btn-primary">
            Create New Employee
          </button>
          {message != "" ? (
            <p className="alert alert-success">{message}</p>
          ) : null}
        </div>
        {empid != 0 ? (
          <div className="col-4">
            <EmpUpdate
              modifyEmpid={empid}
              completed={closeUpdate}
              cancel={updateCanceled}
            />
          </div>
        ) : null}
        {addNew ? (
          <div className="col-4">
            <EmpCreate completed={createCompleted} />
          </div>
        ) : null}
      </div>
    </div>
  );
};

export default EmpList;
