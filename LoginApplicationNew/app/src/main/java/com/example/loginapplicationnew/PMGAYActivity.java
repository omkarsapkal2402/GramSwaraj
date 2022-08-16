package com.example.loginapplicationnew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PMGAYActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DataModel> mList;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmgayactivity);

        recyclerView = findViewById(R.id.main_recyclervie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        //list1
        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Aadhar card");
        nestedList1.add("PAN card (Mandatory)");
        nestedList1.add("passport");
        nestedList1.add("driving license");

        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("Rent agreement");
        nestedList2.add("Voter card");
        nestedList2.add("Credit Card Statement (recent 3 months)");
        nestedList2.add("Property tax payment receipt");
        nestedList2.add("Life Insurance Policy");
        nestedList2.add("Bank Statements displaying the address");nestedList2.add("Map");


        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("Bank statement (Last 6 months");
        nestedList3.add("ITR receipts");
        nestedList3.add("2 months Salary slips");
        nestedList3.add("Sales Deed");
        nestedList3.add("Sales Agreement");
        nestedList3.add("Property Registration Certificate");
        nestedList3.add("Copy of Builder Payment Receipt");


        List<String> nestedList4 = new ArrayList<>();
        nestedList4.add("factory establishment certificate");
        nestedList4.add("SEBI registration certificate");
        nestedList4.add("trade license");
        nestedList4.add("SSI registration");
        nestedList4.add("PAN card");
        nestedList4.add("sales tax receipt");
        nestedList4.add("registration number issued by ROC");
        nestedList4.add("certificate of factory registration");

        /*List<String> nestedList5 = new ArrayList<>();
        nestedList5.add("Jams and Honey");
        nestedList5.add("Pickles and Chutneys");
        nestedList5.add("Readymade Meals");
        nestedList5.add("Chyawanprash and Health Foods");
        nestedList5.add("Pasta and Soups");
        nestedList5.add("Sauces and Ketchup");
        nestedList5.add("Namkeen and Snacks");
        nestedList5.add("Honey and Spreads");*/

        /*List<String> nestedList6 = new ArrayList<>();
        nestedList6.add("Pasta");
        nestedList6.add("Spices");
        nestedList6.add("Salt");
        nestedList6.add("Chyawanprash");
        nestedList6.add("Maggie");
        nestedList6.add("Sauces and Ketchup");
        nestedList6.add("Snacks");
        nestedList6.add("Kurkure");*/


       /* List<String> nestedList7 = new ArrayList<>();
        nestedList7.add("Decorates");
        nestedList7.add("Tea Table");
        nestedList7.add("Wall Paint");
        nestedList7.add("Furniture");
        nestedList7.add("Bedsits");
        nestedList7.add("Certain");
        nestedList7.add("Namkeen and Snacks");
        nestedList7.add("Honey and Spreads");*/

        mList.add(new DataModel(nestedList1 , "Proof of identity"));
        mList.add(new DataModel( nestedList2,"Address proof"));
        mList.add(new DataModel( nestedList3,"Income proof"));
        mList.add(new DataModel(nestedList4 ,"Address proof(for business)"));
        // mList.add(new DataModel(nestedList5,"Pet Care"));
        // mList.add(new DataModel(nestedList6,"Baby Care"));
        //  mList.add(new DataModel(nestedList7 ,"Personal Care"));

        adapter = new ItemAdapter(mList);
        recyclerView.setAdapter(adapter);
    }
}