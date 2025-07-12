import './App.css'
import {Routes , Route} from "react-router-dom";
import MyAbout from "./pages/MyAbout.jsx";
import SetPrdGoal from "./pages/SetPrdGoal.jsx";
import ToDoList from "./pages/ToDoList.jsx";
import Notfound from "./pages/Notfound.jsx";
import React from "react";
import GoalProgress from "./GoalProgress";

function App() {

  return (
      // <Routes>
      //     <Route path="/MyAbout" element={<MyAbout />} />
      //     <Route path="/SetPrdGoal" element={<SetPrdGoal />}/>
      //     <Route path="/ToDoList" element={<ToDoList />} />
      //     <Route path="*" element={<Notfound />}/>
      // </Routes>
      <div className="App">
          <h1>Goal Progress</h1>
          <GoalProgress progress={75} goalName="Learn React"/>
          <GoalProgress progress={50} goalName="Complete Project"/>
          <GoalProgress progress={90} goalName="Exercise Regularly"/>
      </div>

  );
}

export default App
