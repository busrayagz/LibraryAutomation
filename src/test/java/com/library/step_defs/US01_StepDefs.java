package com.library.step_defs;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class US01_StepDefs {


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection();

    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query = "select id from users";
        DB_Util.runQuery(query);
        DB_Util.getColumnDataAsList("id");

    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {


    }


    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(io.cucumber.datatable.DataTable dataTable) {

    }

    }
