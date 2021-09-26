//var apiURL = '/api/products'; 
//    var data= [];  console.log("test");
//    var option = [
//        {field:"ID",width:10},
//        {field:"CODE", width:160},
//        {field:"NAME", width:420},
//        {field:"BRAND",width:30},
//        {field:"TYPE",width:30},
//        {field:"DESCRIPTION", width:420}
//    ];
//
//    $.getJSON(apiURL, function ( datas ) { console.log("test2");
//        $.each( datas, function( key, val ){
//            data.push( val );
//        });
//    });
//
//    window.onload = function() { console.log("test3");
//        var productTable = $("#productTable"); 
//        var makeTable = $("<table>").appendTo(productTable); 
//        makeTable.css({"border-collapse": "collapse", "border": "1px #CCC solid"});
//
//        $.each( data, function( index, row) { console.log("test3");
//            var makeTr = $("<tr>").appendTo(makeTable);
//            console.log("index : "+index);
//            console.log("row : "+ row);
//
//            $.each( option, function( i, fieldInfo ) {
//                var makeTd = $("<td>").appendTo(makeTr);
//                console.log("Index : "+index);
//                console.log("Row : "+row);
//                console.log( "i : "+i);
//                console.log( "fieldInfo : "+fieldInfo);
//                console.log( "fieldInfo.field : "+fieldInfo.field);
//                console.log( "Row[Field] : "+row[fieldInfo.field]);
//
//                makeTd.html( row[fieldInfo.field]);
//                makeTd.css({"width": fieldInfo.width+"px", "border": "1px #CCC solid"});
//            });
//        });
//    }
    
var apiURL = '/api/products'; 
    var data= [];  
    var option = [
        {field:"id",width:10},
        {field:"code", width:160},
        {field:"name", width:420},
        {field:"brand",width:30},
        {field:"type",width:30},
        {field:"description", width:420},
        {field:"lastModifiedDate", width:160}
    ];

//commented Ajax for testing.

    $.getJSON(apiURL, function ( data ) {
        $.each( data , function( key, val ){
            data.push( val );
        }); 
    });
	console.log(data);

//get the data variable set

//data = [{"lastModifiedDate":"25-Sep-2021","id":1,"code":"P001","name":"MASK ADULT Surgical 3 ply","category":"Health Accessories","brand":"Medicos","type":"Hygiene","description":"Description"},{"lastModifiedDate":"25-Sep-2021","id":2,"code":"P002","name":"Party Cosplay Player Unknown Battlegrounds Clothes Hallowmas PUBG","category":"Men's Clothing","brand":"No Brand","type":"Clothing","description":"Suitable for adults and children"},{"lastModifiedDate":null,"id":4,"code":"P003","name":"Adani","category":"Arfah Amir","brand":"Afia","type":"Afrina","description":"Ammar"}];


//begin creating table on load.
window.onload = function() {
        
        //create table element.
        var makeTable = $("<table>");
        //append table to existing div here it have class "productTable".
        $(".productTable").append($(makeTable));
        //append first row for headings.
        $(makeTable).append($("<tr>"));
        
        //append all heading in loop.
        $.each(option,function(i,dt){
            //simply find first tr and append td with content to it.
            $(makeTable).find("tr").append("<td>"+dt["field"]+"</td>");
        });
    
      // start appending data.
      $.each(data,function(i,row){
        //find tbody in table and add tr to it.
           var nrow = $(makeTable).find('tbody').append("<tr>"); 
       //for each options find its value in data and append to newly created tr above.
           $.each(option,function(j,dt){
              // this is actually what you want..  
              $(nrow).append("<td>"+row[dt["field"]]+"</td>");
            });
       });
    }