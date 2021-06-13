# OSS_2021-1_FinalProject


<img width="708" alt="main" src="https://user-images.githubusercontent.com/83248175/121807234-403b9100-cc8e-11eb-9932-829676c81e05.png">



What does this project do?
==========================
> 1.Saving  personal information about Account

> 2.Records of deposits and withdrawals

> 3.Helping you set and achieve your savings goals

> 4.Provide environment for writing expenditure details
    

**************************************************
****************************************************


Why is this project useful?
===============================

## 1. Goal->Helps smart consumption and save money

<img width="698" alt="goal" src="https://user-images.githubusercontent.com/83248175/121807427-12a31780-cc8f-11eb-975e-4606613166bd.png">

## 2. Expenditure record->Makes you feel the need for management

<img width="705" alt="ex" src="https://user-images.githubusercontent.com/83248175/121807596-c2788500-cc8f-11eb-98ee-8f983405bfd9.png">

## 3. show balance->Helps control consumption & make you aware asset situation
<img width="703" alt="bb" src="https://user-images.githubusercontent.com/83248175/121807630-f0f66000-cc8f-11eb-951e-840a1a5ad3f9.png">


**************************************************************
***************************************************************


How do I get started?
======================

### First, connect to the Raspberry Pi with putty and start the program.  
 Enter the following code for program execution. => java -cp . myMoney.MyMoney  
 
### Enter your name and simple personal information.
<img width="479" alt="dd" src="https://user-images.githubusercontent.com/83248175/121808210-62371280-cc92-11eb-8e42-a1b582e8ec3a.png">

### Next, You can select the function to put the letter whatever you want to use from the main menu that appears.
<img width="238" alt="mm" src="https://user-images.githubusercontent.com/83248175/121807800-a5908180-cc90-11eb-908e-7b30324fabdf.png">

+ Deposit
+ Withdrawl
+ Goal setting
<img width="306" alt="aa" src="https://user-images.githubusercontent.com/83248175/121808356-00c37380-cc93-11eb-8a74-70f9efcaf0a4.png">

+ Your Account Info
<img width="289" alt="g" src="https://user-images.githubusercontent.com/83248175/121808418-66affb00-cc93-11eb-85cb-ca37de780ab7.png">

+ Record Expenditure in detail
    > make category
    
    > make entry expence to category
    
    > check expenditure record
    
+ Check Balance
 >> You can check ramaining money in your account & and check how much more money you need to deposit to achieve your goal.
<img width="355" alt="q" src="https://user-images.githubusercontent.com/83248175/121808594-256c1b00-cc94-11eb-995b-2ae2af38aff7.png">
**************************************************************
***************************************************************



What is my contribution to this project?
=========================================
    
1.Overall program design improvement
---------------------------------------
   > The original source had a strong feel to the user, 
   > but I improved the overall design to give the user a customized and private feeling.
    
2.Add personal information storage menu
----------------------------------------
   > Original source was a program that simply popped up a menu. 
   > I implemented the program by requiring the user's name to be entered from the start of service 
   > use to display the account name indicating that it belongs only to the user and to store personal information.

3.Add deposit goal setting menu
--------------------------------------
   > I coded so that users can set their target deposit amount and know the rate of achievement compared to the target amount. 
   > It is also set to motivate with a message that you are doing well when you achieve it.

    
 4.Added rejection function 
 ----------------------------------
> I improved the function 
> For example, if you try to widthraw money more than deposited money, then the program rejects your quest. 
> And also if you recorded the detailed expenditure amount more than withdrawls money my program rejects it too.. 
  >> Withdrawal amount>Deposit amount  => reject
  
  >> Expense Record Amount > Withdrawal Amount =>reject
 
**********************************************************
**********************************************************
## Presentation Video (YouTube) Link
https://youtu.be/qdycGtv_m6k

### Contribute to
https://github.com/Talark/MyMoney-PA-PI-b.git

### Reference
https://gist.github.com/ihoneymon/652be052a0727ad59601

