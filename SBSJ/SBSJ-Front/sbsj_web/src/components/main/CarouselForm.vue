<template>
	<div id="mainTopCarousel" class="carousel slide" align="center" data-bs-ride="carousel" data-bs-interval="5000">
		<div class="carousel-inner">
			<div class="carousel-item active carousel">
				<div class="main-top-promotion">
					<router-link :to="{ name: 'SurveyPage' }" style="text-decoration: none;">
						<img class="main-top-promotion-image" src="@/assets/carousel/carouselImg01.png" alt="Image 1">
					</router-link>
				</div>
			</div>
			<div class="carousel-item carousel">
				<div class="main-top-promotion">
					<img class="main-top-promotion-image" src="@/assets/carousel/carouselImg02.png" alt="Image 2">
				</div>
			</div>
		</div>
		<!-- <div class="carousel-indicators">
			<button type="button" data-bs-target="#mainTopCarousel" data-bs-slide-to="0" class="indicator active" aria-current="true" aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#mainTopCarousel" data-bs-slide-to="1" class="indicator" aria-label="Slide 2"></button>
		</div> -->
		<button class="carousel-control-prev" type="button" data-bs-target="#mainTopCarousel" data-bs-slide="prev" @click="pass">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#mainTopCarousel" data-bs-slide="next" @click="pass">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
		</button>
	</div>
</template>

<script>

export default {
    name: "CarouselForm",
	methods: {
		pass() {
			let carousel1 = document.getElementsByClassName("carousel-item")[0];
			let carousel2 = document.getElementsByClassName("carousel-item")[1];

			// let indicator1 = document.getElementsByClassName("indicator")[0];
			// let indicator2 = document.getElementsByClassName("indicator")[1];

			if(carousel1.classList.contains("active")) {
				carousel1.classList.remove("active");
				carousel2.classList.add("active");
				// indicator1.classList.remove("active");
				// indicator2.classList.add("active");
			} else {
				carousel1.classList.add("active");
				carousel2.classList.remove("active");
				// indicator1.classList.add("active");
				// indicator2.classList.remove("active");
			}
		}
	}
}

</script>

<style>
	.main-top-promotion {
		position: relative;
		width: 99%;
		height: 500px;
	}
	.main-top-promotion-image {
		height: 100%;
		width: 100%;
		margin: 0px;
		padding: 0px;
		position: absolute;
		left: 0;
		top: 0;
		object-fit: cover;
	}
	.main-top-promotion>.container {
		position: relative;
		
	}
	.carousel-control-next,
	.carousel-control-prev {
		width: 7% !important;
	}
</style>