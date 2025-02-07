
<style>
.carousel-inner.vertical {
  height: 100%; /*Note: set specific height here if not, there will be some issues with IE browser*/
}
.carousel-inner.vertical > .item {
  -webkit-transition: .6s ease-in-out top;
  -o-transition: .6s ease-in-out top;
  transition: .6s ease-in-out top;
}

@media all and (transform-3d),
(-webkit-transform-3d) {
  .carousel-inner.vertical > .item {
    -webkit-transition: -webkit-transform .6s ease-in-out;
    -o-transition: -o-transform .6s ease-in-out;
    transition: transform .6s ease-in-out;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    -webkit-perspective: 1000;
    perspective: 1000;
  }
  .carousel-inner.vertical > .item.next,
  .carousel-inner.vertical > .item.active.right {
    -webkit-transform: translate3d(0, 33.33%, 0);
    transform: translate3d(0, 33.33%, 0);
    top: 0;
  }
  .carousel-inner.vertical > .item.prev,
  .carousel-inner.vertical > .item.active.left {
    -webkit-transform: translate3d(0, -33.33%, 0);
    transform: translate3d(0, -33.33%, 0);
    top: 0;
  }
  .carousel-inner.vertical > .item.next.left,
  .carousel-inner.vertical > .item.prev.right,
  .carousel-inner.vertical > .item.active {
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
    top: 0;
  }
}

.carousel-inner.vertical > .active {
  top: 0;
}
.carousel-inner.vertical > .next,
.carousel-inner.vertical > .prev {
  top: 0;
  height: 100%;
  width: auto;
}
.carousel-inner.vertical > .next {
  left: 0;
  top: 33.33%;
  right:0;
}
.carousel-inner.vertical > .prev {
  left: 0;
  top: -33.33%;
  right:0;
}
.carousel-inner.vertical > .next.left,
.carousel-inner.vertical > .prev.right {
  top: 0;
}
.carousel-inner.vertical > .active.left {
  left: 0;
  top: -33.33%;
  right:0;
}
.carousel-inner.vertical > .active.right {
  left: 0;
  top: 33.33%;
  right:0;
}

#carousel-pager .carousel-control.left {
    bottom: initial;
    width: 100%;
}
#carousel-pager .carousel-control.right {
    top: initial;
    width: 100%;
    
    }
</style>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="carousel-main" class="carousel slide " data-ride="carousel" data-interval="5000">
                <div class="carousel-inner">
                    <div class="active item">
                        <img src="resources/images/cc22.jpg" class="img-responsive">
                    </div>
                        <div class="item">
                        <img src="resources/images/cc25.png" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="resources/images/cc15.jpg" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="resources/images/cc16.jpg" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="resources/images/cc20.jpg" class="img-responsive">
                    </div>
                    <div class="item">
                        <img src="resources/images/cc21.jpg" class="img-responsive">
                    </div>
                </div>


                <!-- Controls -->
                <a class="left carousel-control" href=".carousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href=".carousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

       
                
              
            </div>
        </div>
