document.addEventListener('DOMContentLoaded', function() {
    // Highlight BDD keywords
    document.querySelectorAll('.step-name').forEach(function(el) {
        el.innerHTML = el.innerHTML
            .replace(/\b(Given|When|Then|And|But)\b/g, '<span style="color:#00bcd4;font-weight:bold;">$1</span>');
    });
    // Add a floating BDD legend
    let legend = document.createElement('div');
    legend.innerHTML = '<b>BDD Legend:</b> <span style="color:#00bcd4;">Given/When/Then/And/But</span>';
    legend.style = 'position:fixed;bottom:20px;right:20px;background:#222;color:#fff;padding:8px 16px;border-radius:8px;z-index:9999;box-shadow:0 2px 8px #0005;';
    document.body.appendChild(legend);
});