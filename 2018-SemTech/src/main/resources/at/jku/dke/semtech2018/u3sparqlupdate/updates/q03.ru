PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX : <http://example.org/> 

INSERT {?p :nrOfFriends ?nr}
WHERE 
  { SELECT ?p (COUNT(?f) AS ?nr)
    WHERE 
      { ?p a :Person.
        ?p :friend ?f.
      }
    GROUP BY ?p  	
  }
