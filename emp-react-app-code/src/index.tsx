import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";

import { BrowserRouter, Route, Routes } from "react-router-dom";

import {EmpCreate} from "./components/emp-create";
import { EmpList } from "./components/emp-list";
import EmpUpdate from "./components/emp-update";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="emplist" element={<EmpList />} />
        <Route path="empcreate" element={<EmpCreate />} />
        <Route path="empupdate/:id" element={<EmpUpdate/>} />
      </Route>
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);



