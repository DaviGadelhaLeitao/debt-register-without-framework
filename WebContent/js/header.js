var main = function() {
	$("#dropdown-link").on("click", function() {
		$(".dropdown-menu").toggle();
	});
};
$(document).ready(main);