document.addEventListener('DOMContentLoaded', function() {
    // Filter tabs
    document.querySelectorAll('.filter-tab').forEach(function(tab) {
        tab.addEventListener('click', function() {
            var filter = this.dataset.filter;
            document.querySelectorAll('.filter-tab').forEach(function(t) {
                t.classList.remove('active');
            });
            this.classList.add('active');
            
            document.querySelectorAll('.data-table tbody tr').forEach(function(row) {
                if (filter === 'all' || row.dataset.status === filter) {
                    row.style.display = '';
                } else {
                    row.style.display = 'none';
                }
            });
        });
    });

    // Quick search
    var searchInput = document.getElementById('tableSearch');
    if (searchInput) {
        searchInput.addEventListener('keyup', function() {
            var value = this.value.toLowerCase();
            document.querySelectorAll('.data-table tbody tr').forEach(function(row) {
                var text = row.textContent.toLowerCase();
                row.style.display = text.includes(value) ? '' : 'none';
            });
        });
    }
});