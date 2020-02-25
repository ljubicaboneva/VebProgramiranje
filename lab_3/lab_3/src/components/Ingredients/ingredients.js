import React from 'react';
import {useHistory} from "react-router";
import Ingredient from "./ingredientItem";

const Ingredients=(props) => {

    const history = useHistory();

    const AddClick = (e) => {
        e.preventDefault();
        history.push("/ingredients/new")

    };
    const ingredients =props.ingredients.map((item, index) =>

        <Ingredient ingredient={item} key={index} onDelete={props.onDelete}/>

    );
    if(props.ingredients.length===0){
        return(
        <div>
        <button onClick={AddClick} className="btn btn-outline-secondary">
            <span><strong>Add new ingredient</strong></span>
        </button>
        </div>
        )
    }else {
        return (
            <div className="row">

                <h4 className="text-upper text-left">Ingredients</h4>
                <div className="table-responsive">
                    <table className="table tr-history table-striped small">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Spicy</th>
                            <th scope="col">Veggie</th>

                        </tr>
                        </thead>
                        <tbody>
                        {ingredients}

                        </tbody>
                    </table>
                </div>

                <button onClick={AddClick} className="btn btn-outline-secondary">
                    <span><strong>Add new ingredient</strong></span>
                </button>
            </div>
        )
    }
}

export default Ingredients;