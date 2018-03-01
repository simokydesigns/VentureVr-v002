var gulp = require('gulp'),
  gutil = require('gulp-util'),
  webserver = require('gulp-webserver'),
  imageResize = require('gulp-image-resize');


gulp.task('js', function() {
  gulp.src('WebContent/webapp/view/js/**/*');
});

gulp.task('html', function() {
  gulp.src('WebContent/*.html');
});

gulp.task('css', function() {
  gulp.src('WebContent/webapp/css/*.css');
});

gulp.task('watch', function() {
  gulp.watch('WebContent/webapp/js/**/*', ['js']);
  gulp.watch('WebContent/webapp/css/*.css', ['css']);
  gulp.watch(['WebContent/webapp/*.html',
    'WebContent/webapp/view/*.html'], ['html']);
});

gulp.task('webserver', function() {
  gulp.src('WebContent/webapp/')
    .pipe(webserver({
      livereload: true,
      open: true
    }));
});

//images gulp task
gulp.task('resize', function () {
  gulp.src('WebContent/webapp/img/**/*')
    .pipe(imageResize({
      width : 200,
      height : 200,
      crop : true,
      upscale : false
    }))
    .pipe(gulp.dest('WebContent/webapp/img/'));
});

gulp.task('default', ['watch', 'html', 'js', 'css', 'webserver', 'resize']);
