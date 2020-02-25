import React,{useState,useEffect}  from 'react';
import {Redirect, useHistory} from 'react-router-dom';
import {useParams} from "react-router";
import axios from 'axios';
import IngredientsService from "../../repository/axiosIngredientsRepository";


const IngredientEdit = (props) => {


    const [ingredient,setIngredient] = useState({});
    const {ingredientId} = useParams();
    const history = useHistory();

    useEffect(() => {
       IngredientsService.fetchIngredient(ingredientId).then(data => {
           setIngredient(data.data);
       })
    },[]);

    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onEditIngredient(
            {
                "id": ingredientId,
                "name": e.target.name.value,
                "amount": e.target.amount.value,
                "spicy": e.target.spicy.checked,
                "veggie": e.target.veggie.checked
            }
        );


      history.push("/ingredients/");

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

    const onChangeCheckedHandler = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.checked;
        setIngredient({...ingredient, [paramName]: paramValue});
    };

    return (

        <div>
            <br/>
            <br/>
            <div className="row">

                <form onSubmit={onFormSubmit} className="card">
                    <h4 className="text-upper text-left">Edit Ingredient</h4>
                    <div className="form-group row">
                        <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left">Ingredient name</label>
                        <div className="col-sm-6">
                            <input  className="form-control"
                                    id="ingredient" type="text" required maxLength={50}  name={"name"} value={ingredient.name}
                                    defaultValue={ingredient.name} placeholder="Ingredient name" onChange={onChangeHandler}/>
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left">Amount</label>
                        <div className="col-sm-6">
                            <input type="text" onChange={onChangeHandler} required maxLength={50} name={"amount"} value={ingredient.amount} defaultValue={ingredient.amount}  className="form-control" id="amount" placeholder="Amount"/>
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="veggie" className="col-sm-4 offset-sm-1 text-left">Veggie</label>
                        <div className="col-sm-6 col-xl-4">
                            <input type="checkbox"  onChange={onChangeCheckedHandler} name={"veggie"} value={ingredient.veggie} defaultChecked={ingredient.veggie}  className="form-control" id="veggie"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                        <div className="col-sm-6 col-xl-4">
                            <input type="checkbox" onChange={onChangeCheckedHandler} name={"spicy"} value={ingredient.spicy} defaultChecked={ingredient.spicy}  className="form-control" id="spicy"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <div
                            className="offset-sm-1 col-sm-3  text-center">
                            <button
                                disabled={!ingredient.name || !ingredient.amount}
                                type="submit"
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
export  default IngredientEdit