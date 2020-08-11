let canvas2 = document.createElement('canvas'), // 创建canvas
    _canvas = document.querySelector('.share-popup .content'), //此处可换body，或div等 我们一般可以放绘制的元素
    w = parseInt(window.getComputedStyle(_canvas).width),
    h = parseInt(window.getComputedStyle(_canvas).height);

//将canvas画布放大若干倍，然后盛放在较小的容器内，就显得不模糊了
canvas2.width = w * 2;
canvas2.height = h * 2;
canvas2.style.width = w + 'px';
canvas2.style.height = h + 'px';

let context = canvas2.getContext('2d'),
    rect = $('.share-popup .content').get(0).getBoundingClientRect(); //获取元素相对于视察的偏移量

context.scale(2, 2);
context.translate(-rect.left,-rect.top); //设置context位置，值为相对于视窗的偏移量负值，让图片复位

// =====================================注意注意注意=================================
// 必须先scale,再traslate，如果不是绘制全屏的话，这两句可以不加，正常绘制就会把margin区域也绘制上，如果需要不绘制margin区域，而且这个元素就根据窗口大小而居中，我们很不好控制，所以我们再这里先获取 getBoundingClientRect() 根据元素偏移，最后绘制出来全屏的，

html2canvas(document.querySelector('.share-popup .content'), {
    canvas: canvas2,
    useCORS: true, // 允许图片跨域
    width: 584,  // 绘制图片的宽 2倍
    dpi: window.devicePixelRatio * 2, // dpi  如果模糊的话 就把dpi和scale缩放的值调大 dpi越高生成的图片越大
    height: 1188 // 绘制图片的高 2倍
}).then(function(canvas) {
    $('.share-canvas').css('display','block').attr('src', canvas.toDataURL());
});