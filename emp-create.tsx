import axios from "axios";
import { FunctionComponent, useState } from "react";
import { useForm } from "react-hook-form";
import Employee from "../model/employee";

interface EmpcreateProps {
    completed:()=>void
}

const Empcreate: FunctionComponent<EmpcreateProps> = (props:EmpcreateProps) => {

    const [message,setMessage] = useState("");
  const {
    register,
    handleSubmit,
    formState: { errors},
  } = useForm<Employee>();

  const [msgStyle,setMsgStyle]=useState({color:'green'})
  const saveData = (data: Employee) => {
   axios.post("http://localhost:8080/employees",data)
   .then(
       (response)=>{setMessage(response.data.message);
        setMsgStyle({color:'green'})
     },
       (error) =>{
           setMessage(error.response.data.message)
           setMsgStyle({color:'red'})
        }
   )
  };

  return (
    <div>
      <h3>Create Employee</h3>
      <form onSubmit={handleSubmit(saveData)}>
        <div className="form-group">
          Employee Id:
          <input
            type="number"
            className="form-control"
            {...register("empid", { required: true })}
          />
        </div>

        { errors.empid ?(<div className='text-danger'>Employee Id required</div>):null    }

        <div className="form-group">
          Name:
          <input
            className="form-control"
            {...register("name", { required: true, minLength: 5 })}
          />
        </div>
        { errors.name && errors.name.type=='required' ?(<div className='text-danger'>Name is required</div>):null    }
        { errors.name && errors.name.type=='minLength' ?(<div className='text-danger'>Name should be minimum 5 chars</div>):null    }
  
        <div className="form-group">
          Salary:
          <input
            type="number"
            className="form-control"
            {...register("salary", { required: true, min: 10000 })}
          />
        </div>
        
        { errors.salary && errors.salary.type=='required' ?(<div className='text-danger'>Salary is required</div>):null    }
        { errors.salary && errors.salary.type=='min' ?(<div className='text-danger'>Salary should be minimum 10000</div>):null    }
  
      
        <div className="form-group">
          Date of Birth:
          <input
            type="date"
            className="form-control"
            {...register("dob", { required: true })}
          />
        </div>
        { errors.dob ?(<div className='text-danger'>Date of Birth required</div>):null    }
        <div>
          <button type="submit" className="btn btn-primary" >
            Save Data
          </button>
          <button className='btn btn-info' onClick={props.completed}>Back To List</button>
        </div>
      </form>
      {message !=''?(<p style={msgStyle}>{message}</p>):null}
    </div>
  );
};

export default Empcreate;

