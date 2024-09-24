Feature: Flemish Pofi Sanity validate
  validating the user information in Pofi component

  @sanity
  Scenario: Inloggen in POFI
    Given Fetch Rijksregisternummer from database
     Then click on OK button appear in info window
    When Click on Meldaan link
    Then Click on eID en aangesloten kaartlezer link
    And Enter Rijksregisternummer in to edit field
    And Click on Login button
    Then click on OK button appear in info window

  @sanity
  Scenario: Emailadres invullen
    Given Click on Spelen en Weddenschappen Link
    When Enter email address as
    Then Click on verdergaan button

  @sanity
  Scenario: Nieuwe aangifte aanmaken
    Given Click on addAangifte Button
    When Select Belastbare period from dropdown
    Then Click on volgende button

  @sanity
  Scenario: Spel of weddenschap, kanspelinrichting en belastbaar bedrag toevoegen
    When Click on Spel of weddenschap toevoegen button
    And Select Spel definition type from dropdown
    And Select pdf file
    Then Upload file lisence

  @sanity
  Scenario: Aggree terms and conditions
    When Click on agree validate box
    And Click on submit button
    And Click on yes button

  #start TAX-component
  @sanity
  Scenario Outline: validate dossierinformatie
    Given Open new tab
    Then Login in to Tax application
    Then Fill in RR/KBO/BIS-nummer
    And Click on zoeken button
    And validate Email is '<Email>'
    And validate Vergunningstype is '<Vergunningstype>' and Vergunningsnummer
    And validate organisator fields of '<organisatorfields>' are filled in Dossier page

    Examples: 
      | Email                 | Vergunningstype | organisatorfields                                                             |
      | sanity.check@test.com | F1              | Partij id:,Naam:,Straat:,Gemeente:,Land:,Type adres:,Status:,Speciaal Status: |

  @sanity
  Scenario Outline: validate aangifte-informatie in het overzicht van de aangiftes
    When Click on Aangifte tab
    And validate Aangifte type is '<Aangifte>' Status is '<Status>' and Aangeboden ter inkohiering is '<inkohiering>'
    Then select the row
    And Click glass Icon

    Examples: 
      | Aangifte | Status      | inkohiering |
      | Aangifte | Controle OK | ja          |

  @sanity
  Scenario Outline: validate aangifte-informatie in het detail van de aangifte
    When validate information is filled in in detail van de aangifte in detail van de aangifte
    Then Click on spelen button
    And validate type is '<AangifteType>' in spelen en weddenschappen
    Then select the row
    And validate Kanspelinrichting is '<Kanspelinrichting>' in Kansspelinrichting
    And validate Vergunningstype is '<Vergunningstype>' in vergunninsinformatie
    And Click glass Icon

    Examples: 
      | AangifteType     | Kanspelinrichting | Vergunningstype |
      | Sportevenementen | Klasse IV - Vast  | F1              |
      
       @sanity
  Scenario: validate Aangegeven bedrag amount
   #When validate Aangegeven bedrag is 
   When Click on Berekening button
   Then select the row
    And Click glass Icon
    And Close Current Browser
    
     @sanity
  Scenario: validate pdf in dvs module
   Given Launch dvs application
   Then Enter National Number 
    And Click search Icon
    And Click on dossier Number
    Then wait for document upload
    And Click on Document
    
    