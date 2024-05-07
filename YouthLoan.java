package org.example;
import java.util.*;
import java.time.*;

class loan {
  int loanM;
  int l1;
  static int loanFun(int a1) {
    double f1;
    double f2;
    int l1;
    int l2;


    f1 = a1 * 0.8;
    f2=Math.ceil(f1);

    if (f2 > 1000)
    {
      l1=(int)f2;
     l1=1000;
     l2=l1;
      return l2;

    }
    else
    {
      l1=(int)f2;
      return l1;
    }

  }




  void printOutLaonM()
  {

    loanM=loanFun(l1);
    System.out.println(loanM);

  }




}

public class YouthLoan {
  public static void main(String[] args) {

    java.util.Scanner scanner = new java.util.Scanner(System.in);
    loan a1 = new loan();


    System.out.println("請輸入出生年 : ");
      while(scanner.hasNextInt()) {

        int by = scanner.nextInt();
        System.out.println("請輸入出生月份 : ");
        int bm = scanner.nextInt();
        System.out.println("請輸入出生日期 : ");
        int bd = scanner.nextInt();
        LocalDate birthd = LocalDate.of(by, bm, bd);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birthd, now);
        System.out.println("今年" + p.getYears() + "歲");
        int prsntAge=p.getYears();

        if(prsntAge >= 18)
        {

          System.out.println("是否有自用住宅? 1:有 2:無 :");
          int type1=scanner.nextInt();
          if(type1==2)
          {
              System.out.println("配偶是否有自用住宅? 1:有 2:無 :");
                int type2=scanner.nextInt();
                if(type2==2)
                {
                  System.out.println("未成年子女是否有自用住宅? 1:有 2:無 :");
                  int type3=scanner.nextInt();
                  if(type3==2)
                      {
                        System.out.println("請輸入貸款金額 單位(萬): ");
                        int type = scanner.nextInt();
                        a1.loanFun(type);

                        System.out.println("可貸金額:" + a1.loanFun(type) + "萬");


                        System.out.println("總貸款期數480期");

                          System.out.println("\n請選擇方案: 1.一段式機動利率  2.二段式機動利率： 3.混合式固定利率： ");
                          int type4=scanner.nextInt();
                          switch (type4)
                            {


                              case 1 :

                                System.out.println("選擇方案 1: 一段式機動利率 ");
                                System.out.println("總貸款期數480期");
                                int loanM=a1.loanFun(type);


                                double loan1 = (loanM * (0.02305 / 12)) / (1 - Math.pow(1 + (0.02305 / 12), -480));

                                double loan11=Math.round(loan1*1000);
                                int loanP1=(int)loan11;

                                int Loantotal=(loanP1*480)/1000;


                                double loanP1M=(double)loanP1/1000;


                                System.out.println("總金額為 : "+Loantotal+"萬元");
                                System.out.println("每期繳交金額 : "+loanP1M+"萬元");


                                break;
                              case 2 :

                                System.out.println("選擇方案 2: 二段式機動利率 ");

                                //前两年利率为基准利率 + 0.345% = 1.72% + 0.345% = 2.065%。
                                //之后利率为基准利率 + 0.645% = 1.72% + 0.645% = 2.365%。
                                //
                                //首先计算前两年的固定本金支付额，然后计算剩余期数的等额本息分期摊还。

                                System.out.println("總貸款期數480期");
                                int loanM2=a1.loanFun(type);


                                //前兩年利率計算
                                double loan2 = (loanM2 * (0.02065 / 12)) / (1 - Math.pow(1 + (0.02065 / 12), -480));
                                double loan22=Math.round(loan2*1000);
                                int loanP2=(int)loan22;
                                double loanP2M=(double)loanP2/1000;

//                                int Loantotal2=(loanP2*480)/1000;


                                //後面期數利率計算
                                double loan2b = (loanM2 * (0.02365 / 12)) / (1 - Math.pow(1 + (0.02365 / 12), -480));
                                double loan22b=Math.round(loan2b*1000);
                                int loanP2b=(int)loan22b;
                                double loanP2Mb=(double)loanP2b/1000;

                                //計算總和
                                double loant2f=loanP2M*2;
                                double loant2b=loanP2Mb*438;

                                double loantt=loant2f+loant2b;






                                System.out.println("二段式機動利率 前兩年每期應繳金額 :"+ loanP2M+"萬元");
                                System.out.println("二段式機動利率 兩期後每期應繳金額 :"+ loanP2Mb+"萬元");
                                System.out.println("二段式機動利率 總金額為 : "+loantt+"萬元");

                                break;
//                                System.out.println("每期繳交金額 : "+loanP2M+"萬元");



                              case 3 :



                            }

                        break;
                      }
                      else
                      {
                        System.out.println("尚未符合貸款資格");
                        break;
                      }
                  }
                  else
                  {
                    System.out.println("尚未符合貸款資格");
                    break;
                  }

            }
            else
            {
              System.out.println("尚未符合貸款資格");
              break;
            }




        }
        else
        {
          System.out.println("尚未符合貸款資格");
          break;
        }




      }
















  }
}
