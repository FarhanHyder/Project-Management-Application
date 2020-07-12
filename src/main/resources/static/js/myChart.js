var chartDataStr = decodeHtml(chartData);
var chartDataJSON = JSON.parse(chartDataStr);

var arrayLen = chartDataJSON.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLen; i++){
	numericData[i] = chartDataJSON[i].value;
	labelData[i] = chartDataJSON[i].label;
}


new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#4daf4a","#377eb8","#e41a1c"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display: true,
    		text: 'Project Status'
    	}
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}