const modules = import.meta.glob('../components/common/*');
const components = {
    install: (app: any) => {
        for (let path in modules) {
            modules[path]().then(async (mod: any) => {
                await app.component(mod['default']['__name'], mod['default']);
            })
        }
    }
}
export default components;