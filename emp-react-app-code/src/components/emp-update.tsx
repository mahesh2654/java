import axios from "axios";
import { ChangeEvent, FunctionComponent, useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

import { Employee } from "../employee";

const EmpUpdate: FunctionComponent = () => {
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(true);
  const [dataFound, setDataFound] = useState(false);

  const [emp, setEmp] = useState<Employee>({
    empid: 0,
    name: "",
    salary: 0,
    dob: new Date(),
  });

  let params = useParams(); // use to get all path parameters
  let navigate=useNavigate()

  useEffect(() => {
    axios
      .get(`http://localhost:8080/employees/${params.id}`)
      .then((response) => {
        setEmp(response.data);
        setLoading(false);
        setDataFound(true);
      })
      .catch((error) => {
        setMessage(error.response.data.message);
        setLoading(false);
        setDataFound(false);
      });
  }, []);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    let name: string = e.target.name;
    let value: string = e.target.value;

    if (name == "name") emp.name = value;
    if (name == "salary") emp.salary = parseFloat(value);
    if (name == "dob") emp.dob = new Date(value);
  };

  const saveData = () => {
    axios
      .put(`http://localhost:8080/employees/`, emp)
      .then((response) => {
        setMessage(response.data.message);

        setTimeout( () => { navigate('/emplist') }, 4000 );

      })
      .catch((error) => {
        setMessage(error.response.data.message);
      });
  };

  if (loading) {
    return <h3>Loading Data....</h3>;
  }

  if (dataFound) {
    return (
      <>
        <h2>Modify Emp data</h2>
        <div className="form-group">
          Emp Id:
          <input
            type="text"
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
        <div className="d-grid gap-2">
          <button className="btn btn-primary" onClick={saveData}>
            Save Data
          </button>
          <Link to="/emplist" className="btn btn-danger">
            Cancel
          </Link>
        </div>

        <div>
        {message != "" ? <p className="alert alert-success">{message}</p> : null}
      </div>
      </>
    );
  } else {
    return (
      <div style={{marginTop:"50px"}}>
        {message != "" ? <p className="alert alert-danger">{message}</p> : null}
      </div>
    );
  }
};

export default EmpUpdate
