document.addEventListener('DOMContentLoaded', function() {
    // Get all the form elements we need
    const valueInput = document.getElementById('value');
    const fromUnitSelect = document.getElementById('fromUnit');
    const toUnitSelect = document.getElementById('toUnit');
    const resultDisplay = document.getElementById('resultValue');
    const convertForm = document.getElementById('convertForm');
    
    // Get the current conversion type from the page URL
    const currentPage = window.location.pathname.substring(1);
    
    // Define the event handler for performing real-time conversion
    function performConversion() {
        // Get the input value
        const value = valueInput.value;
        
        // Only proceed if we have a value
        if (value && !isNaN(value)) {
            const fromUnit = fromUnitSelect.value;
            const toUnit = toUnitSelect.value;
            
            // Make an AJAX request to the appropriate API endpoint
            fetch(`/api/convert/${currentPage}?value=${value}&fromUnit=${fromUnit}&toUnit=${toUnit}`)
                .then(response => response.text())
                .then(result => {
                    // Update the result field
                    if (resultDisplay) {
                        resultDisplay.textContent = result;
                        
                        // Make the result container visible
                        const resultContainer = document.querySelector('.result');
                        if (resultContainer) {
                            resultContainer.style.display = 'block';
                        }
                    }
                })
                .catch(error => console.error('Error performing conversion:', error));
        }
    }
    
    // Add event listeners for real-time conversion
    if (valueInput && fromUnitSelect && toUnitSelect) {
        valueInput.addEventListener('input', performConversion);
        fromUnitSelect.addEventListener('change', performConversion);
        toUnitSelect.addEventListener('change', performConversion);
        
        // Prevent the form from actually submitting since we're doing everything via AJAX
        if (convertForm) {
            convertForm.addEventListener('submit', function(event) {
                event.preventDefault();
                performConversion();
            });
        }
    }
});
