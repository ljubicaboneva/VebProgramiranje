import React,{useState}  from 'react';
import {Redirect, useHistory} from 'react-router-dom';


const ingredientAdd = (props) => {

    const history = useHistory();
    const [ingredient,setIngredient] = useState({});

    const onFormSubmit = (e) => {
        e.preventDefault();
        const newIngredient = {
             "name": document.getElementById("ingredient").value,
             "amount": document.getElementById("amount").value,
             "veggie": document.getElementById("veggie").checked,
             "spicy": document.getElementById("spicy").checked

        };
        props.onNewIngredientAdded(newIngredient);

    };

    const onCancel = (e) => {
        e.preventDefault();
        history.push("/ingredients")
    };

    const onReset = (e) => {
        e.preventDefault();
        document.getElementById("ingredient").value = "";
        document.getElementById("amount").value = "";
        document.getElementById("veggie").checked = false;
        document.getElementById("spicy").checked = false;
    };

    const onChangeHandler = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setIngredient({...ingredient, [paramName]: paramValue});
    };



    return (
    <div>
        <br/>
        <br/>
        <div className="row">

            <form onSubmit={onFormSubmit} className="card">
                <h4 className="text-upper text-left">Add Ingredient</h4>
                <div className="form-group row">
                    <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left">Ingredient name</label>
                    <div className="col-sm-6">
                        <input type="text" onChange={onChangeHandler} name={"name"} value={ingredient.name} className="form-control" required maxLength={50} id="ingredient" placeholder="Ingredient name"/>
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left">Amount</label>
                    <div className="col-sm-6">
                        <input type="text" onChange={onChangeHandler}  name={"amount"} value={ingredient.amount} className="form-control" required maxLength={50} id="amount" placeholder="Amount"/>
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="veggie" className="col-sm-4 offset-sm-1 text-left">Veggie</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" className="form-control" id="veggie"/>
                    </div>
                </div>

                <div className="form-group row">
                    <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" className="form-control" id="spicy"/>
                    </div>
                </div>

                <div className="form-group row">
                    <div className="offset-sm-1 col-sm-3  text-center">
                        <button type="submit"
                            disabled={!ingredient.name || !ingredient.amount}
                            className="btn btn-primary text-upper">
                            Save
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button onClick={onReset}
                            className="btn btn-warning text-upper">
                            Reset
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button onClick={onCancel}
                            className="btn btn-danger text-upper">
                            Cancel
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
       )
};

export default ingredientAdd;