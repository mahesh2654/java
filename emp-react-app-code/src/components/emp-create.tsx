import axios from "axios";
import React from "react";
import { useState } from "react";
import { useForm} from "react-hook-form";
import { Employee } from "../employee";


export  const EmpCreate = () => {
  const [message, setMessage] = useState("");

  const {
    register,
    handleSubmit,
    reset,
    formState:{errors},
  } = useForm<Employee>();

  const onSubmit = (data: Employee) => {
   // console.log("data", data);

    axios
    .post("http://localhost:8080/employees",data)
    .then((response) => {
      setMessage(response.data.message)
    })
    .catch((error) => {
      setMessage(error.response.data.message);
    });
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="container">
        <h3 className="header"> create Employee</h3>

        <div className="form-group">
          <label htmlFor="empid">Emp Id</label>
          <input
            id="empid"
            className="form-control"
            {...register("empid", { required: true, pattern: /[1-9][0-9]{2}/ })}
          />
        </div>

        {errors.empid && errors.empid.type === "required" ? (
          <div className="text-danger">Employee Id is required</div>
        ) : null}

        {errors.empid && errors.empid.type === "pattern" ? (
          <div className="text-danger">Exact 3 digits and first non-zero</div>
        ) : null}

        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            id="name"
            className="form-control"
            {...register("name", { required: true, minLength: 3 })}
          />
        </div>
        {errors.name && errors.name.type === "required" ? (
          <div className="text-danger">Name is required</div>
        ) : null}
        {errors.name && errors.name.type === "minLength" ? (
          <div className="text-danger">Name should be minimum 3 chars</div>
        ) : null}
        <div className="form-group">
          <label htmlFor="salary">Salary </label>
          <input
            id="salary"
            className="form-control"
            {...register("salary", { required: true, min: 10000 })}
          />
        </div>
        {errors.salary && errors.salary.type === "required" ? (
          <div className="text-danger">Salary is required</div>
        ) : null}
        {errors.salary && errors.salary.type === "min" ? (
          <div className="text-danger">Minimum salary 10000</div>
        ) : null}
        <div className="form-group">
          <label htmlFor="dob">D O B</label>
          <input
            type="date"
            id="dob"
            className="form-control"
            {...register("dob", { required: true })}
          />
        </div>
        {errors.dob && errors.dob.type === "required" ? (
          <div className="text-danger">DOB is required</div>
        ) : null}
        <div className="d-grid gap-2">
          <button className='btn btn-primary'  type="submit" >
            Save
          </button>
          <button className="btn btn-danger" onClick={()=>reset()}>
            Clear Form
          </button>
        </div>
        {message!=='' && (<div>{message}</div>)}
      </div>
    </form>
  );
};
