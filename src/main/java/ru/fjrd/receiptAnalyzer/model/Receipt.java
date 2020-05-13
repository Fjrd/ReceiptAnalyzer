package ru.fjrd.receiptAnalyzer.model;

import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    Long dateTime;
    Integer ecashTotalSum;
    Integer cashTotalSum;
    //Integer discountSum;
    Long fiscalDocumentNumber;
    Long fiscalDriveNumber;
    Long fiscalSign;
    ArrayList<Item> items;

    public void toScreen(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Check{" +
                "\n\tdateTime=" + new Date(dateTime) +
                ", \n\tecashTotalSum=" + ecashTotalSum / 100 + " руб" +
                ", \n\tcashTotalSum=" + cashTotalSum / 100 + " руб"+
                //", \n\tdicsountSum=" + discountSum / 100 + " руб"+
                ", \n\tfiscalDocumentNumber=" + fiscalDocumentNumber +
                ", \n\tfiscalDriveNumber=" + fiscalDriveNumber +
                ", \n\tfiscalSign=" + fiscalSign +
                ", \n\titems=" + items +
                '}';
    }
}
