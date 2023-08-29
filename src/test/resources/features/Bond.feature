@ON-865
Feature: Bond

	#As a RM user, I should be able to create bond order successfully
  @ON-842 @ON-848 @ON-850
  Scenario Outline: Successful Buy Bond Order "<scenario>"
    Given I login as Admin user "<username>", "<password>"
    When I navigate to "Bonds" page
    And I create order bonds with "<portfolio>","<instrument>","<nominal_price>","<client_price>","<spread>","<phone>","<instructed_by>","<contact>","<override_reason>"
    Then The order status should be "Order"

    Examples: Bond Orders Data
      | username | password | portfolio   |  | instrument      | nominal_price | client_price | spread | phone   | instructed_by | contact        | override_reason | scenario   |
      | wui_rm1  | wui_rm1  | 11292021-01 |  | FI-US06738EBK01 | 100000        | 1000         | 31     | 6593320 | SG1234567     | 00213546985100 | Automated Test  | Scenario 1 |
      | wui_rm2  | wui_rm2  | 11292021-01 |  | FI-US06738EBK01 | 100000        | 1000         | 31     | 6593320 | SG1234567     | 00213546985100 | Automated Test  | Scenario 2 |

