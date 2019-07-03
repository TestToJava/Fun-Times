# Fun-Times
A collection of challenges from along the way

## To Start the program , run the com.ford.test.HeneryStoreTest

Date of the Offer Date can be changed in com.ford.test.utils.DiscountUtils.
private static LocalDate today = LocalDate.parse("03-07-2019", formatter);(The Base Date)

As we are not getting the Order Date from command prompt, I kept the Offer Date as Development Date.
If We will run this Application after 08-07-2019 then We can avail Apple 10% offer. 


## Quantity of the Items should be minimum 0 in number.

### Command Prompt will ask you to enter the Quantity 

Please select the Quantity of Items:[minimum Zero]  

[Apples]: 3 

[Milk]: 0 

[Bread]: 1  

[Soup]: 2 

Order Invoice Will be generated like Below:

[Name	Type	Price] 

[----	----	-----]

[Apples	Single	0.10]

[Apples	Single	0.10] 

[Apples	Single	0.10] 

[Bread	Loaf	0.40] 

[Soup	Tin	0.65] 

[Soup	Tin	0.65] 

Amount Payable: 2.00
