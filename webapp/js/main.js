document.addEventListener('DOMContentLoaded', function() {
    // Auto-dismiss alerts
    document.querySelectorAll('.alert').forEach(function(alert) {
        setTimeout(function() {
            alert.style.transition = 'opacity 0.5s ease';
            alert.style.opacity = '0';
            setTimeout(function() { alert.remove(); }, 500);
        }, 5000);
    });

    // Password match validation for registration
    var registerForm = document.getElementById('registerForm');
    if (registerForm) {
        registerForm.addEventListener('submit', function(e) {
            var pass = document.getElementById('password').value;
            var confirm = document.getElementById('confirmPassword').value;
            if (pass !== confirm) {
                e.preventDefault();
                alert('Passwords do not match!');
            }
        });
    }

    // Phone number - digits only
    var phoneInput = document.getElementById('phone');
    if (phoneInput) {
        phoneInput.addEventListener('input', function() {
            this.value = this.value.replace(/[^0-9]/g, '');
        });
    }

    // Confirm delete
    document.querySelectorAll('.delete-confirm').forEach(function(btn) {
        btn.addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to delete this?')) {
                e.preventDefault();
            }
        });
    });
});