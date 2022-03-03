import { Alert, Button, Container, Table } from "react-bootstrap";
import { useEffect, useState } from "react";
import { Employee } from "../employee";


import axios from "axios";
import { Link } from "react-router-dom";
import { getTsBuildInfoEmitOutputFilePath } from "typescript";

export function EmpList() {

    const [message, setMessage] = useState<string>("");
    const [employees, setEmployees] = useState<Employee[]>([]);
  
    useEffect(() => loadData(),[]);
  
    // functions for operations
  
    let deleteData = (empid: number) => {
      axios.delete(`http://localhost:8080/employees/${empid}`)
        .then((resp) => {
          loadData();
          setMessage(resp.data.message);
        })
        .catch((error) => {
          setMessage(error.response.data.message);
        })
    }
    

    let loadData = () => {
      axios
        .get("http://localhost:8080/employees")
        .then((response) => {
          setEmployees(response.data);
        //  console.log(employees)
        })
        .catch((error) => {
          setMessage(error.response.data.message);
        });
    };
    return (
        <div >
          <h3 style={{ textAlign: "center" }}>List of Employees</h3>
  
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>EMP ID</th>
                <th>NAME</th>
                <th>SALARY</th>
                <th>DOB</th>
                <th>ACTION</th>
              </tr>
            </thead>
            <tbody>
              {employees.map((emp, i) => (
                <tr key={i}>
                  <td>{emp.empid}</td>
                  <td>{emp.name}</td>
                  <td>{emp.salary}</td>
                  <td>{emp.dob}</td>
  
                  <td>
                    <Button  variant="danger"
                      onClick={() => deleteData(emp.empid)}
                    >
                      Delete
                    </Button>
                    <Link
                     to={`/empupdate/${emp.empid}`}  className='btn btn-success'                >
                      Modify
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
          
          {message != "" ? (
            <Alert variant="danger" onClick={() => setMessage("")}>
              {message}
            </Alert>
          ) : null}
        </div>
       
    );
  }
  