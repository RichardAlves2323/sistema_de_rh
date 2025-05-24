import { useState } from "react"
import type { Employee } from "../../../api/entities/employee/Employee"


function CreateEmployee() {

    const [employeeForm, setEmployeeForm] = useState<Employee>();

    const handleChangeInput = (event: React.ChangeEvent<HTMLInputElement>) => {

        const value = event.target.value;
        const key = event.target.name;

        setEmployeeForm({...employeeForm, [key]: value});
    }

    const sendForm = () => {

        console.log(employeeForm);
    }
    return (
        <div>
            <h1 style={{textAlign: 'center'}}>Criar Funcionario</h1>
            <div>
                <div style={{display: "flex", justifyContent: "center"}}>
                    <div style={{paddingRight: "1rem"}}>
                        <label>Primeiro Nome: </label>
                        <input type="text" name="fistName" id="fistNameInput" onChange={handleChangeInput} />
                    </div>
                    <div style={{paddingRight: "1rem"}}>
                        <label>Último Nome: </label>
                        <input type="text" name="lastName" id="lastNameInput" onChange={handleChangeInput} />
                    </div>
                    <div style={{paddingRight: "1rem"}}>
                        <label>Email: </label>
                        <input type="email" name="email" id="emailInput"  onChange={handleChangeInput}/>
                    </div>
                </div>
                <div style={{display: "flex", justifyContent: "center", padding: "2rem"}} >
                    <button onClick={sendForm}>Cadastrar</button>
                </div>
            </div>
            
        </div>
    )
}

export default CreateEmployee