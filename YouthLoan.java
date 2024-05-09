package org.example;
import java.util.*;
import java.time.*;


class loan {

  //宣告空值

  int loanM;
  int l1;

  //貸款額度方法loanFun
  static int loanFun(int a1) {
    double f1;
    double f2;
    int l1;
    int l2;
    //a1代表從main 使用者輸入scanner 值
    f1 = a1 * 0.8;
    //Math.ceil(f1) 取無條件進位，回傳小於等於所給數字的最大整數
    f2=Math.ceil(f1);


    //若貸款金額 乘 8成(0.8)大於1000 後 限度設定最高1000萬
    if (f2 > 1000)
    {
      l1=(int)f2;
     l1=1000;
     l2=l1;
      return l2;
    //回傳l2為1000萬 (最高貸款額度)
    }
    else //若貸款額度*0.8 小於1000萬 回傳l1
    {
      l1=(int)f2;
      return l1;
    }

  }




  //印出結果 當使用者呼叫此類別就會回傳到結果到Main裡
  void printOutLaonM()
  {

    loanM=loanFun(l1);
    System.out.println(loanM);

  }




}

public class YouthLoan {
  public static void main(String[] args) {

    java.util.Scanner scanner = new java.util.Scanner(System.in);

    //建立物件
    loan a1 = new loan();


    System.out.println("請輸入出生年 : ");
      while(scanner.hasNextInt()) {

        int by = scanner.nextInt();
        System.out.println("請輸入出生月份 : ");
        int bm = scanner.nextInt();
        System.out.println("請輸入出生日期 : ");
        int bd = scanner.nextInt();
        //使用時間套件LocalDate (年,月,日) 抓取特定年月日
        LocalDate birthd = LocalDate.of(by, bm, bd);
        //抓取現在時間套件
        LocalDate now = LocalDate.now();
        //利用 時間差 =現在的時間資訊 減掉 特定年月日 等於時間差
        Period p = Period.between(birthd, now);

        //p值 等於時間差.getYears()取年 ,等於年數,年紀
        System.out.println("今年" + p.getYears() + "歲");

        int prsntAge=p.getYears();
        //重新宣告 prsntAge=p值=年紀=年數 也可以不宣告 直接用p.getYears()



            //把年紀放進判斷式 若年紀大於等於18
            if (prsntAge >= 18)
            {

                //建立外循環 設定布林值 若輸入其他數值或輸入預期範圍之外就繼續輪迴 直到使用者輸入正確指令
                boolean reinput12=false;
                while(!reinput12) {

                  System.out.println("是否有自用住宅? 1:有 2:無 :");
                  int type1 = scanner.nextInt();
                  if (type1 == 2) {
                    System.out.println("配偶是否有自用住宅? 1:有 2:無 :");
                    int type2 = scanner.nextInt();
                    if (type2 == 2) {
                      System.out.println("未成年子女是否有自用住宅? 1:有 2:無 :");
                      int type3 = scanner.nextInt();
                      if (type3 == 2) {



                        boolean reinput = false;
                        //建立 內循環 因應若輸入超出範圍就會繼續循環
                        while (!reinput) {
                          System.out.println("請輸入貸款金額 單位(萬): ");
                          int type = scanner.nextInt();
                          if (type >= 0) {


                            //呼叫貸款金額類別函式
                            a1.loanFun(type);

                            //a1.loanFun(type) 為最後類別函式計算後的結果
                            System.out.println("可貸金額:" + a1.loanFun(type) + "萬");

                            System.out.println("總貸款期數480期");

                            boolean ipq=false;
                            //建立 內循環2 因應若輸入超出範圍就會繼續循環

                            while(!ipq) {
                              boolean rechoose = false;

                              //建立 內循環3 因應若輸入超出範圍就會繼續循環
                              while (!rechoose) {
                                //用使用者選擇方案
                                System.out.println("\n請選擇方案: 1.一段式機動利率  2.二段式機動利率： 3.混合式固定利率： ");

                                int type4 = scanner.nextInt();
                                //使用者輸入的值在放入switch case 判斷取得哪些方法
                                switch (type4) {


                                  case 1:


                                    System.out.println("選擇方案 1: 一段式機動利率 ");
                                    System.out.println("總貸款期數480期");
                                    int loanM = a1.loanFun(type);

                                    //利率为基准利率 + 0.585% = 1.72% + 0.585% = 2.305%。
                                    //贷款年限为 40 年，共 40 * 12 = 480 期。


                                    //貸款公式
                                    double loan1 = (loanM * (0.02305 / 12)) / (1 - Math.pow(1 + (0.02305 / 12), -480));
                                    //算出的值 藉Math.round 四捨五入 在*1000
                                    double loan11 = Math.round(loan1 * 1000);
                                    //把值轉換 int
                                    int loanP1 = (int) loan11;
                                    //貸款總額*480(期數)/1000
                                    int Loantotal = (loanP1 * 480) / 1000;

                                    //每一期個別需要繳的金額
                                    double loanP1M = (double) loanP1 / 1000;

                                    System.out.println("一段式機動利率 每期繳交金額 : " + loanP1M + "萬元");
                                    System.out.println("一段式機動利率 總金額為 : " + Loantotal + "萬元");

                                    //關閉內迴圈3
                                    rechoose = true;
                                    break;
                                  case 2:

                                    System.out.println("選擇方案 2: 二段式機動利率 ");

                                    //前两年利率为基准利率 + 0.345% = 1.72% + 0.345% = 2.065%。
                                    //之后利率为基准利率 + 0.645% = 1.72% + 0.645% = 2.365%。
                                    //
                                    //首先计算前两年的固定本金支付额，然后计算剩余期数的等额本息分期摊还。

                                    System.out.println("總貸款期數480期");
                                    int loanM2 = a1.loanFun(type);


                                    //前兩年利率計算
                                    double loan2 = (loanM2 * (0.02065 / 12)) / (1 - Math.pow(1 + (0.02065 / 12), -480));
                                    double loan22 = Math.round(loan2 * 1000);
                                    int loanP2 = (int) loan22;
                                    double loanP2M = (double) loanP2 / 1000;


                                    //後面期數利率計算
                                    double loan2b = (loanM2 * (0.02365 / 12)) / (1 - Math.pow(1 + (0.02365 / 12), -480));
                                    double loan22b = Math.round(loan2b * 1000);
                                    int loanP2b = (int) loan22b;
                                    double loanP2Mb = (double) loanP2b / 1000;

                                    //計算總和
                                    double loant2f = loanP2M * 24;
                                    double loant2b = loanP2Mb * 456;

                                    double loantt = loant2f + loant2b;


                                    System.out.println("二段式機動利率 前兩年每期應繳金額 :" + loanP2M + "萬元");
                                    System.out.println("二段式機動利率 兩年後每期應繳金額 :" + loanP2Mb + "萬元");
                                    System.out.println("二段式機動利率 總金額為 : " + loantt + "萬元");

                                    //關閉內迴圈3
                                    rechoose = true;
                                    break;


                                  case 3:

                                    //混合式固定利率：
                                    //前两年利率分别为基准利率 + 0.525% = 1.72% + 0.525% = 2.245%，和基准利率 + 0.625% = 1.72% + 0.625% = 2.345%。
                                    //之后利率为基准利率 + 0.645% = 1.72% + 0.645% = 2.365%。
                                    //
                                    //首先计算前两年的固定本金支付额，然后计算剩余期数的等额本息分期摊还。


                                    System.out.println("選擇方案 3: 混合式固定利率 ");

                                    System.out.println("總貸款期數480期");
                                    int loanM3 = a1.loanFun(type);


                                    //第一年利率計算
                                    double loan3 = (loanM3 * (0.02245 / 12)) / (1 - Math.pow(1 + (0.02245 / 12), -480));
                                    double loan33 = Math.round(loan3 * 1000);
                                    int loanP3 = (int) loan33;
                                    double loanP3M = (double) loanP3 / 1000;


                                    //第二年利率計算
                                    double loan3b = (loanM3 * (0.02345 / 12)) / (1 - Math.pow(1 + (0.02345 / 12), -480));
                                    double loan33b = Math.round(loan3b * 1000);
                                    int loanP3b = (int) loan33b;
                                    double loanP3Mb = (double) loanP3b / 1000;


                                    //第三年利率計算
                                    double loan3b3 = (loanM3 * (0.02365 / 12)) / (1 - Math.pow(1 + (0.02365 / 12), -480));
                                    double loan33b3 = Math.round(loan3b3 * 1000);
                                    int loanP3b3 = (int) loan33b3;
                                    double loanP3Mb3 = (double) loanP3b3 / 1000;


                                    // 混合式固定利率 計算總和
                                    double loant3f = loanP3M * 12;
                                    double loant3b = loanP3Mb * 12;
                                    double loant3bb = loanP3Mb3 * 456;
//                                // 混合式固定利率 第一期+第二期
//                                double loant3fb=loanP3Mb+loan3b;

                                    //混合式固定利率 (第一期加第二期)+後面期數總和
                                    double loantt3 = loant3f + loant3b + loant3bb;


                                    System.out.println("混合式固定利率 第一年每期應繳金額 :" + loanP3M + "萬元");
                                    System.out.println("混合式固定利率 第一年總應繳金額 :" + loant3f + "萬元");
                                    System.out.println("混合式固定利率 第二年每期應繳金額 :" + loanP3Mb + "萬元");
                                    System.out.println("混合式固定利率 第二年總應繳金額 :" + loant3b + "萬元");
                                    System.out.println("混合式固定利率 第三年每期應繳金額 :" + loanP3Mb3 + "萬元");
                                    System.out.println("混合式固定利率 第三年總應繳金額 :" + loant3bb + "萬元");
                                    System.out.println("混合式固定利率 全總金額為 : " + loantt3 + "萬元");

                                    //關閉內迴圈3
                                    rechoose = true;
                                    break;

                                  default:
                                    System.out.println("代號輸入錯誤,請重新輸入方案代號");

                                    //繼續內迴圈3
                                    rechoose = false;
                                    break;

                                }


                              }

                              reinput = true;
                              System.out.println("是否要重新查詢貸款方案: 1.是 2.否 ");
                              int type4=scanner.nextInt();
                              if(type4==1)
                              {
                                //繼續內迴圈2
                                ipq=false;
                              }
                              else if(type4==2)
                               {
                                 //關閉內迴圈2
                                ipq=true;
                              }
                              else
                              {  System.out.println("輸入錯誤請重新輸入");
                                //關閉內迴圈2
                                ipq=true;
                              }


                            }

                          } else {
                            //繼續內迴圈
                            reinput = false;
                          }



                        }



                        break;
                      } else if (type3 == 1) {
                        System.out.println("尚未符合貸款資格");

                        break;
                      } else {
                        System.out.println("輸入數值超出範圍,請重新輸入: ");

                      }

                    } else if (type2 == 1) {
                      System.out.println("尚未符合貸款資格");

                      break;
                    } else {
                      System.out.println("輸入數值超出範圍,請重新輸入: ");


                    }

                  } else if (type1 == 1) {
                    System.out.println("尚未符合貸款資格");

                    break;

                  } else {
                    System.out.println("輸入數值超出範圍,請重新輸入: ");

                  }

                reinput12=false;
                }
            break;
            }
            else {
              System.out.println("尚未符合貸款資格");
              break;

            }



      }
















  }
}
