Feature: Task02Test
  Implementation of task 2 of Lesson 9 using the Cucumber framework

  Scenario: Sc1
    Given open browser
    Given open main page
    When  input the Blouse text into the search Input
    When  click the search Submit button
    When  click the View List link
    When  click the Add To Cart link of the first product
    When  click the Proceed to Checkout link
    When  click the increase quantity link of the first item

    Then  close the browser
#  Scenario Outline: The increase in the number of goods by 1
#    Given open browser
#    Given open main page
#    When  input the "<searchInput>" text into the search Input
#    When  click the search Submit button
#    When  click the View List link
#    When  click the Add To Cart link of the first product
#    When  click the Proceed to Checkout link
#    When  click the increase quantity link of the first item
#    Then  the Total Product Price value of the first item is "<FirstItemTotalProductPrice>"
#    Then  the Total Product value is "<TotalProduct>"
#    Then  the Total Shipping value is "<TotalShipping>"
#    Then  the Total Price without tax value is "<TotalPriceWithoutTax>"
#    Then  the Total Price value is "<TotalPrice>"
#    When  click the Delete product from Cart link of first item
#    Then  the "Your shopping cart is empty." text is displayed
#    Then  close the browser

#    Examples:
#      | searchInput | FirstItemTotalProductPrice | TotalProduct | TotalShipping | TotalPriceWithoutTax | TotalPrice |
#      | Blouse      | $54.00                     | $54.00       | $2.00         | $56.00               | $56.00     |