
<!-- Sidenav/menu -->
<nav class="w3-sidenav w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidenav">
    <div class="w3-container w3-padding-5">
        <a href="index.jsp"><img src="img/icont.png" style="width:90%"/></a>
    </div>
    <div class="w3-padding-10 w3-large w3-text-grey" style="font-weight:bold">
        <a href="index.jsp"><h3 class="w3-wide w3-hover-text-red"><b>C & F Dress</b></h3></a>
        <hr>
        <a href="showCustomerInfo.jsp">Account</a>
        <div class="w3-accordion">
            <a onclick="myAccFunc(oWear)" href="#">
                Outer Wear <i class="fa fa-caret-down"></i>
            </a>
            <div  id="oWear" class="w3-accordion-content w3-white w3-card-4 ">
                <a href="#">Hoodies & Sweatshirts</a>
                <a href="#">Jackets & Coats</a>
            </div>
        </div>
        <div class="w3-accordion">
            <a onclick="myAccFunc(bottom)" href="#">
                Bottom<i class="fa fa-caret-down"></i>
            </a>
            <div id="bottom" class="w3-accordion-content w3-white w3-card-4 ">
                <a href="#">Shorts</a>
                <a href="#">Pants</a>
            </div>
        </div>
        <a href="#">Bags</a>
        <a href="#">Shoes</a>
        <div class="w3-accordion">
            <a onclick="myAccFunc(accessory)" href="#">
                Accessories<i class="fa fa-caret-down"></i>
            </a>
            <div id="accessory" class="w3-accordion-content w3-white w3-card-4 ">
                <a href="#">Hats</a>
                <a href="#">Glasses</a>
                <a href="#">Watches</a>
            </div>
        </div>

    </div>
</nav>

<script>
    function myAccFunc(item) {
        var x = item;
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-light-grey";
        } else {
            x.className = x.className.replace(" w3-show", "");
            x.previousElementSibling.className =
                    x.previousElementSibling.className.replace(" w3-light-grey", "");
        }
    }
</script>
