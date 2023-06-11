package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.myAccount;
import com.pages.myOrders;
import com.pages.orderNumberPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class generatePDFStepDef {
    com.pages.myAccount myAccount =  new myAccount(BaseDriver.getDriver());
    com.pages.myOrders myOrders =  new myOrders(BaseDriver.getDriver());
    com.pages.orderNumberPage orderNumberPage =  new orderNumberPage(BaseDriver.getDriver());

    @When("User click on My Orders")
    public void userClickOnMyOrders() {
        myAccount.clickOnMyOrders();
    }

    @When("User click on View Orders")
    public void userClickOnViewOrders() {
        myOrders.clickOnViewOrder();
    }

    @Then("User should see the previously created order in the RECENT ORDERS table with the status as pending")
    public void userShouldSeeThePreviouslyCreatedOrderInTheRecentOrdersTableWithTheStatusAsPending() {
        Assert.assertEquals("ORDER #100019475 - PENDING",orderNumberPage.orderStatusMsg());
    }

    @Then("User click on the Print Order link")
    public void userClickOnThePrintOrderLink() throws InterruptedException {
        orderNumberPage.clickOnPrintOrder();
        Thread.sleep(5000);
    }

    @Then("User should see that the order is saved as a PDF")
    public void userShouldSeeThatTheOrderIsSavedAsAPdf() {

        try {
            // Specify the URL or local path of the PDF file
            String pdfUrl = "http://live.techpanda.org/index.php/sales/order/print/order_id/19575/";

            // Load the PDF document
            PDDocument document = PDDocument.load(new URL(pdfUrl).openStream());

            // Create an instance of PDFTextStripper to extract text from the PDF
            PDFTextStripper textStripper = new PDFTextStripper();

            // Extract the text from the PDF
            String pdfText = textStripper.getText(document);

            // Verify if the PDF contains the expected data
            Assert.assertTrue("Order PDF should contain the expected data.",
                    pdfText.contains("ORDER #100019475"));

            // Close the PDF document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
