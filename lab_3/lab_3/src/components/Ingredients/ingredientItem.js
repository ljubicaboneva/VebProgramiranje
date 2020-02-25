import React,{Component} from 'react';
import {useHistory} from 'react-router-dom';
import IngredientService from "../../repository/axiosIngredientsRepository";
import {Link} from "react-router-dom"

class Ingredient extends Component {



    render() {
        return (
            <tr>
                <td>{this.props.ingredient.name}</td>
                <td>{this.props.ingredient.amount}g</td>
                <td>
                    <i className={this.props.ingredient.spicy ? "fa fa-check-circle text-success" : "fa fa-minus-circle text-danger"}/>
                </td>
                <td>
                    <i className={this.props.ingredient.veggie ? "fa fa-check-circle text-success" : "fa fa-minus-circle text-danger"}/>
                </td>
                <td scope="col">
                    <Link to={`/ingredients/${this.props.ingredient.name}/edit`} className="btn btn-sm btn-secondary">
                        <span className="fa fa-edit"/>
                        <span><strong>Edit</strong></span>
                    </Link>
                    <button className="btn btn-sm btn-outline-secondary " onClick={() => this.props.onDelete(this.props.ingredient.name)}>
                        <span className="fa fa-remove"/>
                        <span><strong>Remove</strong></span>
                    </button>
                    <Link to={`/ingredients/${this.props.ingredient.name}/details`} className="btn btn-sm btn-secondary">
                        <span><strong>Details</strong></span>
                    </Link>
                </td>

            </tr>
        )
    }
}
export default Ingredient;