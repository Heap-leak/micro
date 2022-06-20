export default {
    mounted(el,binding) {
        const options = {
            rootMargin: '8px',
            threshold: 1.0
        }

        const callback = (entries, observer) => {
            //&& this.page < this.totalPages
            if(entries[0].isIntersecting  ) {
                binding.value()
            }
        };

        const observer = new IntersectionObserver(callback, options);
        observer.observe(el)
    },
    name: 'intersection'
}