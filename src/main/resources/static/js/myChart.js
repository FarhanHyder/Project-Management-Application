new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: ['January', 'February', 'March', 'April'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#f1a340","#ffffbf","#91cf60","#998ec3"],
            borderColor: 'rgb(255, 99, 132)',
            data: [1, 10, 5, 2]
        }]
    },

    // Configuration options go here
    options: {}
});