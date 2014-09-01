/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwjava1;

import java.util.Scanner;

/**
 *
 * @author SOMMY
 */
public class HWJAVA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Income;
        int TaxRate;
        int i = 0;
        int total = 0;
        Scanner scan = new Scanner(System.in);
        int[] intIncomeRange = new int[4];
        int[] intTaxRate = new int[4];
        while (i < 4) {
            System.out.print("Please enter income and tax rate in tax bracket" + (i + 1) + ":");
            intIncomeRange[i] = scan.nextInt();
            intTaxRate[i] = scan.nextInt();
            System.out.println("IncomeRange : " + intIncomeRange[i]);
            System.out.println("TaxRate : " + intTaxRate[i]);
            i++;
        }//วนลูป รับค่าช่วงรายได้ และ อัตราการเสียภาษี ลงไปเก็บใน อาเรย์ของจำนวนเต็ม 
        System.out.print("Please enter tax rate if income > " + intIncomeRange[3] + " : ");
        int intMaxTaxRate;
        intMaxTaxRate = scan.nextInt();
        System.out.print("Please enter income: ");
        Income = scan.nextInt();
        //รับค่าอัตราภาษีสูงสุด ในกรณีที่เงินได้เกินจากตาราง ไปเก็บไว้ใน int MaxTaxRate
        if (Income > intIncomeRange[0]) {
            if (Income > intIncomeRange[1]) {
                if (Income > intIncomeRange[2]) {
                    if (Income > intIncomeRange[3]) {
                        System.out.println("0 - " + intIncomeRange[0] + " you  pay 0 baht.");
                        System.out.print((intIncomeRange[0] + 1) + " - " + intIncomeRange[1] + " you  pay ");
                        System.out.print(((intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100) + " baht.");
                        total += (intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100;

                        System.out.print((intIncomeRange[1] + 1) + " - " + intIncomeRange[2] + " you  pay ");
                        System.out.print(((intIncomeRange[2] - intIncomeRange[1]) * intTaxRate[2] / 100) + " baht.");
                        total += (intIncomeRange[2] - intIncomeRange[1]) * intTaxRate[2] / 100;

                        System.out.print((intIncomeRange[2] + 1) + " - " + intIncomeRange[3] + " you  pay ");
                        System.out.print(((intIncomeRange[3] - intIncomeRange[2]) * intTaxRate[3] / 100) + " baht.");
                        total += (intIncomeRange[3] - intIncomeRange[2]) * intTaxRate[3] / 100;

                        System.out.print((intIncomeRange[3] + 1) + " - " + Income + " you  pay ");
                        System.out.print(((Income - intIncomeRange[3]) * intMaxTaxRate / 100) + " baht.");
                        total += (Income - intIncomeRange[3]) * intMaxTaxRate / 100;
                        //ส่วนที่ถึง 750,001 บาท – 1,000,000 บาท	ร้อยละ 20
                    } else {
                        System.out.println("0 - " + intIncomeRange[0] + " you  pay 0 baht.");
                        System.out.print((intIncomeRange[0] + 1) + " - " + intIncomeRange[1] + " you  pay ");
                        System.out.print(((intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100) + " baht.");
                        total += (intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100;

                        System.out.print((intIncomeRange[1] + 1) + " - " + intIncomeRange[2] + " you  pay ");
                        System.out.print(((intIncomeRange[2] - intIncomeRange[1]) * intTaxRate[2] / 100) + " baht.");
                        total += (intIncomeRange[2] - intIncomeRange[1]) * intTaxRate[2] / 100;
                        System.out.print((intIncomeRange[2] + 1) + " - " + Income + " you  pay ");
                        System.out.print(((Income - intIncomeRange[2]) * intTaxRate[3] / 100) + " baht.");
                        total += (Income - intIncomeRange[2]) * intTaxRate[3] / 100;
                        //ส่วนที่ถึง 500,001 บาท – 750,000 บาท	ร้อยละ 15
                    }
                } else {
                    System.out.println("0 - " + intIncomeRange[0] + " you  pay 0 baht.");
                    System.out.print((intIncomeRange[0] + 1) + " - " + intIncomeRange[1] + " you  pay ");
                    System.out.print(((intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100) + " baht.");
                    total += (intIncomeRange[1] - intIncomeRange[0]) * intTaxRate[1] / 100;
                    System.out.print((intIncomeRange[1] + 1) + " - " + Income + " you  pay ");
                    System.out.print(((Income - intIncomeRange[1]) * intTaxRate[2] / 100) + " baht.");
                    total += (Income - intIncomeRange[1]) * intTaxRate[2] / 100;
                    //ส่วนที่ถึง 300,001 บาท – 500,000 บาท	ร้อยละ 10
                }

            } else {
                System.out.println("0 - " + intIncomeRange[0] + " you  pay 0 baht.");
                System.out.print((intIncomeRange[0] + 1) + " - " + intIncomeRange[1] + " you  pay ");
                System.out.print(((Income - intIncomeRange[0]) * intTaxRate[1] / 100) + " baht.");
                total += (Income - intIncomeRange[0]) * intTaxRate[1] / 100;
                //ส่วนที่ถึง 150,001 บาท – 300,000 บาท 	ร้อยละ 5
            }

        } else {
            System.out.println("0 - " + intIncomeRange[0] + " you  pay 0 baht."); //1-150,000 บาทแรก ไม่ต้องเสียภาษี (หรือเสียในอัตราร้อยละ 0)
        }

        System.out.println("Total Tax = " + total + " baht.");
    }
}
