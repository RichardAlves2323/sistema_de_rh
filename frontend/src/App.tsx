import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/home";
import CreateEmployee from "./pages/employee/form";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/employee/create" element={<CreateEmployee />}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
