
Feature:test feature

  @cucumberTestcase1
  Scenario: TestCase1 test scenario

    Given user goes to hurriyetemlak.com
    When click on satilik button
    Then click on province filter and select province as İzmir in ad list page
    And click on district filter and select district as Bornova in ad list page
    Then select category as İşyeri in ad list page
    And fill min price as 100000 in ad list page
    And fill max price as 2000000 in ad list page
    Then click on building age filter  in ad list page
    And select building age as Sıfır Bina in ad list page
    And select building age as 1-5 in ad list page
    And select building age as 6-10 in ad list page
    Then click on search button in ad list page
    And check province filter text as İzmir
    And check district filter text as Bornova
    And check category filter text as İşyeri
    And check min price filter text as 100.000
    And check max price filter text as 2.000.000
    And check building age filter

  @cucumberTestcase2
  Scenario: TestCase2 test scenario

    Given user goes to hurriyetemlak.com
    When click on kiralik button
    Then click on province filter and select province as Ankara in ad list page
    And click on district filter and select district as Çankaya in ad list page
    Then select category as Konut in ad list page
    Then click on room type filter in ad list page
    And  select room type as 2+1 in ad list page
    And  click with in site
    Then click on search button in ad list page
    And click first card
    Then click and show phone number