// header
const header = document.querySelector("header")
window.addEventListener("scroll", function(){
    x = window.pageYOffset
    if(x>0){
        header.classList.add("sticky")
    }else{
        header.classList.remove("sticky")
    }

})
//category left
const itemCategoryLeft = document.querySelectorAll(".cartegory-left-li")
itemCategoryLeft.forEach(function(menu,index){
    menu.addEventListener("click",function(){
        menu.classList.toggle("block")
    })
})





// slider
const imgPosition = document.querySelectorAll(".aspect-ratio-169 img")
const imgContainer = document.querySelector('.aspect-ratio-169')
const dotItem = document.querySelectorAll(".dot")
let index = 0
let imgNumber = imgPosition.length
imgPosition.forEach(function(imgae,index){
    imgae.style.left = index*100 + "%"
    dotItem[index].addEventListener("click", function(){
        slider(index)
    })
})

function imgSlider (){
    index++;
    if(index >= imgNumber) {index = 0}
    imgContainer.style.left = "-" +index*100+"%"
    slider(index)

}
function slider(index){
    imgContainer.style.left = "-" +index*100+"%"
    const dotActive = document.querySelector('.active')
    dotActive.classList.remove("active")
    dotItem[index].classList.add("active")
}
setInterval(imgSlider, 3000)