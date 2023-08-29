@ON-865
Feature: Default

	#As a user with invalid account I should be able to see an error message
  @ON-842 @ON-848 @ON-850
  Scenario Outline: Successful Buy Bond Order
    Given I login as Admin user "<username>", "<password>"
    When I navigate to "Bonds" page
    And I create order bonds with "<portfolio>","<instrument>","<nominal_price>","<client_price>","<spread>","<phone>","<instructed_by>","<contact>","<override_reason>",

    Examples: Bond Orders Data
      | username | password | portfolio   |  | instrument      | nominal_price | client_price | spread | phone   | instructed_by | contact        | override_reason |
      | wui_rm1  | wui_rm1  | 11292021-01 |  | FI-US06738EBK01 | 100000        | 1000         | 31     | 6593320 | SG1234567     | 00213546985100 | Automation Test |
      | wui_rm2  | wui_rm2  | 11292021-01 |  | FI-US06738EBK01 | 100000        | 1000         | 31     | 6593320 | SG1234567     | 00213546985100 | Automation Test |