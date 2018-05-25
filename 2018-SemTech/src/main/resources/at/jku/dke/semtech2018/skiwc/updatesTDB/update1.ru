PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX : <http://example.org/> 
PREFIX rdfs:    <http://www.w3.org/2000/01/rdf-schema#>

INSERT DATA {
	:Man a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA {
	:Women a rdfs:Class;
    rdfs:subClassOf :Person.
};

INSERT DATA { 
	:FranzKlammer  a :Skifahrer.
};

INSERT DATA{ 
	:MichaelaDorfmeister a :Skifahrer. 
};

INSERT DATA {
	:Abfahrtsweltcup1977 a :Weltcup.
};
