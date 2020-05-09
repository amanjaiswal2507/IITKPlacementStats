// const Btn = document.querySelector('.BtnWrapper')
// let Status = true
// Btn.addEventListener('click',()=>{
//     const BarOne = document.querySelector('.Bar-1')
//     const BarTwo = document.querySelector('.Bar-2')
//     const BarThree = document.querySelector('.Bar-3')
//     if(Status){
//     BarOne.classList.add('AddBar-1')
//     BarTwo.classList.add('AddBar-2')
//     BarThree.classList.add('AddBar-3')
//     Status = false
//     }else{
//         BarOne.classList.remove('AddBar-1')
//         BarTwo.classList.remove('AddBar-2')
//         BarThree.classList.remove('AddBar-3')
//         Status = true
//     }
// })
const test = document.getElementById('INPUT')
const Btn = document.getElementById('Btn').addEventListener('click', () => {
    const A_Tag = document.getElementById('A_tag')
    A_Tag.href = `/${test.value}`
})
