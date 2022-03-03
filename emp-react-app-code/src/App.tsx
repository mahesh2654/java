import React from "react";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import { Link, Outlet } from "react-router-dom";

const App: React.FC = () => {
  return (
    <div>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to={"emplist"} className="nav-link">
              Emp List
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"empcreate"} className="nav-link">
              Create Emp
            </Link>
          </li>
        </div>
      </nav>

      <div className="container col-6">
        <Outlet />
      </div>
    </div>
  );
};

export default App;
