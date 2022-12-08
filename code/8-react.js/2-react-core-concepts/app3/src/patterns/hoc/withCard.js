

// HOF / HOC
function withCard(InputComponent) {

    function Container(props) {
        return (
            <div className="card">
                <div className="card-header">{props.title}</div>
                <div className="card-body">
                    <InputComponent {...props} />
                </div>
            </div>
        )
    }

    Container.displayName = `${InputComponent.name}-Card` // for dev-tools
    return Container
}

export { withCard }